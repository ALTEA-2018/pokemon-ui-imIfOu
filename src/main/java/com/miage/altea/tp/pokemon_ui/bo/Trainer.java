package com.miage.altea.tp.pokemon_ui.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class Trainer implements UserDetails {

    private String name;

    private String password;

    @JsonProperty("pokemons")
    private List<Pokemon> team;

    private List<PokemonType> teamPokemon;

    private String urlIcon;

    public Trainer() {}

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public String getUrlIcon() { return urlIcon; }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public List<PokemonType> getTeamPokemon() {
        return teamPokemon;
    }

    public void setTeamPokemon(List<PokemonType> teamPokemon) {
        this.teamPokemon = teamPokemon;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authoritySet = new HashSet<>();
        authoritySet.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authoritySet;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}