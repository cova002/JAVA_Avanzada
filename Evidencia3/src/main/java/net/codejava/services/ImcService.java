/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.services;

import java.util.List;
import net.codejava.entity.Imc;
import net.codejava.repositories.ImcRepository;
import net.codejava.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jajimenez
 */
@Service
public class ImcService {

    @Autowired
    private ImcRepository imcRepository;
    private UsuarioRepository repo;
    public List<Imc> listAllImc() {
	return imcRepository.findAll();
	}
    public void save(Imc imc) {
        imcRepository.save(imc);
    }

}
