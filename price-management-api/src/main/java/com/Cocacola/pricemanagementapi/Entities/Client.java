package com.Cocacola.pricemanagementapi.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name ="tb_client")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Cnpj;

    private String name;

    private String email;


    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ClientProduct> clienteProdutos;
    
    

}
