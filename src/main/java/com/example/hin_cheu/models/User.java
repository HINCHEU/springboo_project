//package com.example.hin_cheu.models;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Change to IDENTITY
//    private Long id;
//
//    @Column(nullable = false, name = "username")
//    private String username;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = true, name = "phone")
//    private String phone;
//
//    @Column(name = "role")
//    private Long role;
//
//    @Column(name = "status")
//    private String status;
//
//    @Column(name = "email_verified_at")
//    private LocalDateTime emailVerifiedAt; // Use LocalDateTime for date handling
//
//    @Column(name = "remember_token")
//    private String rememberToken; // Use camelCase for field names
//
//    @Column(nullable = false)
//    private String password;
//
//    @Transient
//    private String confirmPassword;
//
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt; // Use LocalDateTime for date handling
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt; // Use LocalDateTime for date handling
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Long getRole() {
//        return role;
//    }
//
//    public void setRole(Long role) {
//        this.role = role;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getEmailVerifiedAt() {
//        return emailVerifiedAt;
//    }
//
//    public void setEmailVerifiedAt(LocalDateTime emailVerifiedAt) {
//        this.emailVerifiedAt = emailVerifiedAt;
//    }
//
//    public String getRememberToken() {
//        return rememberToken;
//    }
//
//    public void setRememberToken(String rememberToken) {
//        this.rememberToken = rememberToken;
//    }
//
//    public String getPassword() {
//        return password; // This method was missing
//    }
//
//    public void setPassword(String password) {
//
//        this.password = password; // Hash the password
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", role=" + role +
//                ", status='" + status + '\'' +
//                ", emailVerifiedAt=" + emailVerifiedAt +
//                ", rememberToken='" + rememberToken + '\'' +
//                ", password='" + password + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}
//
package com.example.hin_cheu.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(nullable = false, name = "username")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private Long role;

    @Column(name = "status")
    private String status;

    @Column(name = "email_verified_at")
    private LocalDateTime emailVerifiedAt;

    @Column(name = "remember_token")
    private String rememberToken;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Change to IDENTITY
//    private Long id;
//
//    @Column(nullable = false, name = "username")
//    private String username;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = true, name = "phone")
//    private String phone;
//
//    @Column(name = "role")
//    private Long role;
//
//    @Column(name = "status")
//    private String status;
//
//    @Column(name = "email_verified_at")
//    private LocalDateTime emailVerifiedAt; // Use LocalDateTime for date handling
//
//    @Column(name = "remember_token")
//    private String rememberToken; // Use camelCase for field names
//
//    @Column(nullable = false)
//    private String password;
//
//    @Transient
//    private String confirmPassword;
//
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt; // Use LocalDateTime for date handling
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt; // Use LocalDateTime for date handling

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(LocalDateTime emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public String getPassword() {
        return password; // This method was missing
    }

    public void setPassword(String password) {

        this.password = password; // Hash the password
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", status='" + status + '\'' +
                ", emailVerifiedAt=" + emailVerifiedAt +
                ", rememberToken='" + rememberToken + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}