package br.com.diegomarques.classes.entities;

import br.com.diegomarques.classes.entities.enums.ClassificadorEnum;

public interface IClassificador {
    ClassificadorEnum classificar(Cliente cliente);
}
