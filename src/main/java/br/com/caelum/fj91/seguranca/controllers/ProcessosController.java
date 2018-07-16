package br.com.caelum.fj91.seguranca.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.fj91.seguranca.models.Processo;
import br.com.caelum.fj91.seguranca.repositories.ProcessoRepository;

@Controller
@RequestMapping("/processos")
public class ProcessosController {
	
	private static final String PAGINA_PROCESSOS = "processos/processos";
	private static final String PAGINA_CADASTRO_PROCESSO = "processos/processo-form";
	private static final String REDIRECT_PAGINA_PROCESSOS = "redirect:/processos";
	
	private static final Sort SORT_BY_DATA_DESC = Sort.by("dataDeCadastro");
	
	private final ProcessoRepository processoRepository;

	public ProcessosController(ProcessoRepository processoRepository) {
		this.processoRepository = processoRepository;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("processos", processoRepository.findAll(SORT_BY_DATA_DESC));
		return PAGINA_PROCESSOS;
	}
	
	@GetMapping("/form")
	public String form() {
		return PAGINA_CADASTRO_PROCESSO;
	}
	
	@PostMapping
	@Transactional
	public String adicionar(Processo processo, RedirectAttributes redirectModel) {
		this.processoRepository.save(processo);
		redirectModel.addFlashAttribute("msg", "Processo cadastrado com sucesso!");
		return REDIRECT_PAGINA_PROCESSOS;
	}
	
	@PatchMapping("/{id}/aceitar")
	@Transactional
	public String aceitar(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		Processo emAnalise = processoRepository.getOne(id);
		emAnalise.aceitar();
		this.processoRepository.save(emAnalise);
		redirectModel.addFlashAttribute("msg", "Processo aceito com sucesso!");
		return REDIRECT_PAGINA_PROCESSOS;
	}
	
	@PatchMapping("/{id}/rejeitar")
	@Transactional
	public String rejeitar(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		Processo emAnalise = processoRepository.getOne(id);
		emAnalise.rejeitar();
		this.processoRepository.save(emAnalise);
		redirectModel.addFlashAttribute("msg", "Processo rejeitado com sucesso!");
		return REDIRECT_PAGINA_PROCESSOS;
	}
	
	@PatchMapping("/{id}/encerrar")
	@Transactional
	public String encerrar(@PathVariable("id") Long id, RedirectAttributes redirectModel) {
		Processo emAndamento = processoRepository.getOne(id);
		emAndamento.encerrar();
		this.processoRepository.save(emAndamento);
		redirectModel.addFlashAttribute("msg", "Processo encerrado com sucesso!");
		return REDIRECT_PAGINA_PROCESSOS;
	}
	
}
