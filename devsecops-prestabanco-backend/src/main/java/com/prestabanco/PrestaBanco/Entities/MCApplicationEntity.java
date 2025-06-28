package com.prestabanco.PrestaBanco.Entities;

import com.sun.jdi.LongValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "mc_application")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MCApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long status;
    private Long type;
    private Long client;
    private Long executive;

    private int loanAmount; //En CLP
    private int loanTerm; //En años
    private double annualInterestRate; //En %
    private double lienInsurance; // En %
    private double fireInsurance; //En CLP
    private double administrationCommission; //En %
}
