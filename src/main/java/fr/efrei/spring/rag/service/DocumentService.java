package fr.efrei.spring.rag.service;

import fr.efrei.spring.rag.domain.Document;
import fr.efrei.spring.rag.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {
    private final Logger log = LoggerFactory.getLogger(DocumentService.class);
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document buildAndSave(Document document) {
        log.debug("Request to save Document : {}", document);
        return documentRepository.save(document);
    }

    public Iterable<Document> findAll() {
        log.debug("Request to get all Documents");
        return documentRepository.findAll();
    }

    public Optional<Document> findbyId(Long id) {
        log.debug("Request to get Document by id : {}", id);
        return documentRepository.findById(id);
    }

    public void deleteById(Long id) {
        log.debug("Request to delete Document : {}", id);
        documentRepository.deleteById(id);
    }
}
