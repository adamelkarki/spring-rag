package fr.efrei.spring.rag.repository;

import fr.efrei.spring.rag.domain.Document;
import fr.efrei.spring.rag.repository.dto.DocumentDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
    @Query(
            "select distinct new fr.efrei.spring.rag.repository.dto.DocumentDto(document.title, document.content) from Document document"
    )
    List<DocumentDto> findAllDocuments();
}
