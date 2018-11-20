package br.com.apoio.managedbean;

import javax.faces.bean.ManagedBean;

import br.com.apoio.bo.DesenvolvedorDAO;
import br.com.apoio.bo.MySQLAccess;
import br.com.apoio.model.Desenvolvedor;

@ManagedBean
public class DesenvolvedorMB {
//Instanciando Objetos 
Desenvolvedor dev = new Desenvolvedor();
MySQLAccess dao = new MySQLAccess();
DesenvolvedorDAO devDAO = new DesenvolvedorDAO();
	private String status = "erro";
	String teste = "erro";
	public Desenvolvedor getDesenvolvedor() {
		return dev;
	}
	public void setDesenvolvedor(Desenvolvedor dev) {
		this.dev = dev;	
	}
	public String status () {
		return status;
	}
	public String abrirCadastro () {
		return "cadastro";
	}
	//Inserir dados na tabela dev
	public String insertDev() throws Exception {
		if (dev.getNome().equals("fernando")) {
			teste = "erro";
		}
		else {
		teste = devDAO.InsertDataBase(dev);
		status = "Dev inserido";
		}
		return teste;
	}
	//Testando conexão
	public String ConexaoBanco() throws Exception {
		teste = dao.readDataBase();
		status = status();
		return teste;
	}
	//excluir dev
	public String excluirDev() throws Exception {
		String nome = dev.getNome();
		teste = devDAO.DeleteData(nome);
		status = "Dev Excluído";
		return teste;
	}
	public String UpdateData() throws Exception {
		String nome = dev.getNome();
		Double salario = dev.getSalario();
		teste = devDAO.UpdateData(nome, salario);
		return teste;
	}
	
}
