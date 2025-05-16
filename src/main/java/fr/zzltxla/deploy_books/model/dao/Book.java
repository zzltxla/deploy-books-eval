/**
 * 
 */
package fr.zzltxla.deploy_books.model.dao;


/**
 * @author zzltxla
 * 
 */
public class Book {
    
    /**
     * Book name
     */ 
    private String name;

    /**
     * Book id
     */ 
    private Long id;

    /**
     * Default constructor
     */ 
    public Book(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId (long id) {
        this.id = id;
    }

    /**
     * @return id
     */
    public Long getId () {
        return id;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName () {
        return name;
    }

    @Override 
    public String toString() {
        return "Book [name=" + name + ", id=" + id +"]";
    }
} 
