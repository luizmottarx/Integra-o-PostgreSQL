package com.ti2cc;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		while (true)
		{	
			System.out.println("Digite o valor da ação a ser realizada");
			System.out.println("1)Insere um elemento na tabela \n 2)Mostra usuario do sexo masculino \n 3)Atualiza usuario \n 4)Exclui usuario \n 5)Mostra usuarios \n ");
			System.out.println("Digite qualquer outro valor para sair desta operação");
			Scanner s = new Scanner(System.in);
			int entrada = s.nextInt();
			
			switch(entrada)
			{
			case 1:
				
				//Insere um elemento na tabela
				Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
				if(dao.inserirUsuario(usuario) == true) {
					System.out.println("Inserido com sucesso -> " + usuario.toString());
				}
			
			    continue;
			
			case 2:
				
				//Mostra usuario do sexo masculino		
				System.out.println("==== Mostrando usuarios do sexo masculino === ");
				Usuario[] usuarios = dao.getUsuariosMasculinos();
				for(int i = 0; i < usuarios.length; i++) {
					System.out.println(usuarios[i].toString());
				}
				
				continue;
				
			case 3:
				
				//Atualiza usuario
				Usuario usuario1 = new Usuario(11,"caio","caio",'M');
				usuario1.setSenha("nova senha");
				dao.atualizarUsuario(usuario1);
				
				continue;
				
			case 4:
				
				//Exclui usuario
				Usuario usuario2 = new Usuario(11,"caio","caio",'M');
				dao.excluirUsuario(usuario2.getCodigo());
				
				continue;
				
			case 5:
				
				//Mostra usuarios
				usuarios = dao.getUsuarios();
				System.out.println("==== Mostrando usuarios === ");		
				for(int i = 0; i < usuarios.length; i++) {
					System.out.println(usuarios[i].toString());
				}
				
				continue;
				
				default:
					dao.close();
				return;
		
			}
		}
	}
}