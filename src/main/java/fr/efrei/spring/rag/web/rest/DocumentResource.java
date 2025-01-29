package fr.efrei.spring.rag.web.rest;

import fr.efrei.spring.rag.domain.Document;
import fr.efrei.spring.rag.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class DocumentResource {
    private final Logger log = LoggerFactory.getLogger(DocumentService.class);
    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> addDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to save Document : {}", document);
        Document result = documentService.buildAndSave(document);

        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(result);
    }

    @GetMapping("/documents/getAll")
    public ResponseEntity<Iterable<Document>> getAllDocuments() {
        log.debug("REST request to get all Documents");
        Iterable<Document> result = documentService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/documents/delete/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        log.debug("REST request to delete Document : {}", id);
        documentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/documents/chat2/{user}")
    public String chat2(@RequestBody String query) throws InterruptedException {
        String result = documentService.chat(query);
        return result;
    }
}
