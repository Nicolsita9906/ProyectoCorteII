package com.example.Proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.Proyecto.modelos.Empleado;
import com.example.Proyecto.service.EmpleadoService;
import com.example.Proyecto.service.JwtService;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/Supermercado/empleados")
public class EmpleadoController {
    
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(JwtService jwtService, PasswordEncoder passwordEncoder, EmpleadoService empleadoService) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.empleadoService = empleadoService;
    }

  
@PostMapping("/registro-inicial")
	public ResponseEntity<?> registroInicial(@RequestBody Empleado empleado) {
    // Verificar si ya existen usuarios
   	 if(empleadoService.listarEmpleados().isEmpty()) {
        empleado.setContraseña(new BCryptPasswordEncoder().encode(empleado.getContraseña()));
        return ResponseEntity.ok(empleadoService.agregarEmplado(empleado));
    	}
    	return ResponseEntity.badRequest().body("Ya existe un usuario registrado");
	}

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Empleado> optionalEmpleado = empleadoService.listarEmpleados().stream()
            .filter(e -> e.getNumeroDocuemento().equals(loginRequest.getNumeroDocumento()))
            .findFirst();
        
        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.get();
            if (passwordEncoder.matches(loginRequest.getContraseña(), empleado.getContraseña())) {
                String jwt = this.jwtService.generateJwtToken(empleado);
                return ResponseEntity.ok(new LoginResponse(
                    jwt, 
                    empleado.getNumeroDocuemento(),
                    empleado.getNombreEmpleado(),
                    empleado.getTipoDocumento()
                ));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
    }

    // Create
    @PostMapping
    public ResponseEntity<?> agregarEmpleado(@RequestBody Empleado empleado) {
        try {
            //Encriptar la contraseña antes de guardar
            empleado.setContraseña(passwordEncoder.encode(empleado.getContraseña()));
            empleadoService.agregarEmplado(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Read (All)
    @GetMapping
    public ResponseEntity<?> listarEmpleados(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        String token = this.jwtService.extractToken(authHeader);
        if (token == null || !this.jwtService.validateJwtToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token JWT inválido o faltante");
        }
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    // Read (By ID)
    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarEmpleado(@PathVariable int codigo, @RequestHeader(value = "Authorization", required = false) String authHeader) {
        String token = this.jwtService.extractToken(authHeader);
       if (token == null || !this.jwtService.validateJwtToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token JWT inválido o faltante");
        }
        
        try {
            Empleado empleado = empleadoService.buscarEmpleado(codigo);
            return ResponseEntity.ok(empleado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/{codigo}")
    public ResponseEntity<?> modificarEmpleado(@PathVariable int codigo, @RequestBody Empleado empleado, @RequestHeader(value = "Authorization", required = false) String authHeader) {
        String token = this.jwtService.extractToken(authHeader);
        if (token == null || !this.jwtService.validateJwtToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token JWT inválido o faltante");
       }
        
        try {
             //Encriptar la contraseña si se está actualizando
            if (empleado.getContraseña() != null) {
               empleado.setContraseña(passwordEncoder.encode(empleado.getContraseña()));
            }
            empleadoService.modificarEmpleado(codigo, empleado);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable int codigo, @RequestHeader(value = "Authorization", required = false) String authHeader) {
        String token = this.jwtService.extractToken(authHeader);
        if (token == null || !this.jwtService.validateJwtToken(token)) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token JWT inválido o faltante");
       }
        
        try {
            empleadoService.eliminarEmpleado(codigo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Inner class for login request
    public static class LoginRequest {
        private String numeroDocumento;
        private String contraseña;

        // Getters y Setters
        public String getNumeroDocumento() {
            return numeroDocumento;
        }

        public void setNumeroDocumento(String numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
        }

        public String getContraseña() {
            return contraseña;
        }

        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
        }
    }

    // Inner class for login response
    public static class LoginResponse {
        private String token;
        private String numeroDocumento;
        private String nombre;
        private int tipoDocumento;

        public LoginResponse(String token, String numeroDocumento, String nombre, int tipoDocumento) {
            this.token = token;
            this.numeroDocumento = numeroDocumento;
            this.nombre = nombre;
            this.tipoDocumento = tipoDocumento;
        }

        // Getters
        public String getToken() {
            return token;
        }

        public String getNumeroDocumento() {
            return numeroDocumento;
        }

        public String getNombre() {
            return nombre;
        }

        public int getTipoDocumento() {
            return tipoDocumento;
        }
    }
}