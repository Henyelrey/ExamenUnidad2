/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.modelo;

import lombok.Data;



@Data
public class ResultadoTO {
     public int IdResultado, Punto;
    public String NombrePartida, NombreJugador1, NombreJugador2, Ganador, Estado;
}
