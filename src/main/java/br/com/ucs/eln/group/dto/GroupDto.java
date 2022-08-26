package br.com.ucs.eln.group.dto;

import java.time.LocalDateTime;
import java.util.List;

public class GroupDto {

    private Long id;
    private LocalDateTime created;
    private String name;
    private String description;
    private boolean admin;
    private List<FunctionDto> functions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<FunctionDto> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionDto> functions) {
        this.functions = functions;
    }
}
