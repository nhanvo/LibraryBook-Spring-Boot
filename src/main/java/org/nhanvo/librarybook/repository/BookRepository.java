package org.nhanvo.librarybook.repository;

import org.nhanvo.librarybook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 
 * @author nhanvo
 * Book repository class, inheritance from JPA repository
 */
public interface BookRepository extends JpaRepository<Book, Long>{
	/**
	 * Find one book by author 
	 * @param author Author name
	 * @return
	 */
	Optional<Book> findOneByAuthor(String author);
}
