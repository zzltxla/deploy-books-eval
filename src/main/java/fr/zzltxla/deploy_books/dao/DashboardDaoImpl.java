/**
 * 
 */
package fr.zzltxla.deploy_books.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.zzltxla.deploy_books.model.dao.Book;

@Repository
public class DashboardDaoImpl implements DashboardDao {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardDaoImpl.class);

    private static final String SQL_SELECT_ALL_BOOKS            = "select * from books";

    @Autowired
    @Qualifier("jdbcTemplateDashboard")
    private JdbcTemplate            jdbcTemplateDashboard;

    /*
    *
    */ 
    public DashboardDaoImpl() {

    }

    @Override
    @Cacheable(value = "books")
    public List<Book> getAllBooks() {
        LOGGER.debug("getAllBooks <- ()");
        List<Book> ret = null;
        try {
            ret = jdbcTemplateDashboard.query(SQL_SELECT_ALL_BOOKS, (resultSet, rowNum) -> new Book(
                resultSet.getString("books_name"),
                resultSet.getLong("books_id")
            ));
        } catch (Exception e) {
            LOGGER.error("Erreur getAllBooks " + e.getMessage(), e);
        } finally {
            LOGGER.debug("getAllBooks -> () - return '{}'", ret);
        }
        return ret;
    }
}
