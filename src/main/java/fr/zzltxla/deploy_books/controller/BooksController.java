/**
 * 
 */
package fr.zzltxla.deploy_books.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.zzltxla.deploy_books.dao.DashboardDao;
import fr.zzltxla.deploy_books.model.dao.Book;
import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("${deploys_books.url")
public class BooksController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);

    @Autowired 
    private DashboardDao dashboardDao;

    @GetMapping("/books")
    @Operation(description="Récupérer tout les livres")
    public ResponseEntity <List<Book>> getAllBooks() {
        LOGGER.info("getAlllBooks <- ()");

        try {
            List<Book> response = dashboardDao.getAllBooks();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e ) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } finally {
            LOGGER.info("getAllBooks -> ()");
        }
    }
}
