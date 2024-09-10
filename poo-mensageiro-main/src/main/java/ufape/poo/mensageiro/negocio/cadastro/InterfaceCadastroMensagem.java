package ufape.poo.mensageiro.negocio.cadastro;

import java.util.List;
import ufape.poo.mensageiro.negocio.basica.Mensagem;
import ufape.poo.mensageiro.negocio.cadastro.exception.AutoMensagemException;

public interface InterfaceCadastroMensagem {

	List<Mensagem> listarMensagensRemente(Long id);

	Mensagem salvarMensagem(Mensagem entity) throws AutoMensagemException;

	List<Mensagem> listarTodasMensagens();

	void apagarMensagem(Mensagem entity);

}