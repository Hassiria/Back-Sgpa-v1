package br.edu.ufape.poo.sgpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.sgpa.controller.dto.request.TurmaRequest;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import br.edu.ufape.poo.sgpa.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TurmaService implements TurmaServiceInterface {
	
	@Autowired
	private TurmaRepository repository;
	
	@Override
	public Turma buscarTurmaPorId(Long id) {
		return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Turma não encontrada"));
	}
	
	@Override
	public List<Turma> buscarTurmasPorModalidade(Modalidade modalidade) {
		return repository.findByModalidade(modalidade);
	}

	@Override
	public List<Turma> buscarTurmasPorInstrutor(Instrutor instrutor) {
		return repository.findByInstrutor(instrutor);
	}

	@Override
	public List<Turma> buscarTurmasPorModalidadeOuInstrutor(Modalidade modalidade, Instrutor instrutor) {
		return repository.findByModalidadeOrInstrutor(modalidade, instrutor);
	}

	@Override
	public boolean verificarExistenciaTurmaId(Long id) {
		return repository.existsById(id);
	}

	@Override
	public void deletarTurma(Long id) {
		if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Turma não existe");
        }
		repository.deleteById(id);
	}

	@Override
	public List<Turma> listarTurmas() {
		return repository.findAll();
	}
	
	@Override
	public Turma atualizarTurma(Long id, TurmaRequest turmaRequest) {
        Turma turmaExistente = repository.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Turma não existe")
        );

        turmaExistente.setInstrutor(turmaRequest.getInstrutor());
        turmaExistente.setModalidade(turmaRequest.getModalidade());
        turmaExistente.setSala(turmaRequest.getSala());
        turmaExistente.setVaga(turmaRequest.getVaga());

        return repository.save(turmaExistente);
    }
	
	@Override
	public Turma cadastrarTurma(TurmaRequest turmaRequest) {
        Turma turma = new Turma();
        
        turma.setInstrutor(turmaRequest.getInstrutor());
        turma.setModalidade(turmaRequest.getModalidade());
        turma.setSala(turmaRequest.getSala());
        turma.setVaga(turmaRequest.getVaga());
        
        return repository.save(turma);
    }
}
