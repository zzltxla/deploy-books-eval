import { useState, useEffect } from "react";
import type { Book } from "../interface/Book";
import { api } from "../environment/environment-dist";

export interface fetchBooksType {
    books: Book[];
    loading: boolean;
    error: string;
}

function GetAllBooks ():fetchBooksType {

    const [books, setBooks] = useState<Book[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string>('');

    useEffect(() => {
        const fetchBooks = async () => {
            setLoading(true);
            try {
                const response = await fetch(`${api.url}/books`, {mode: 'no-cors'});
                
                const data = await response.json();

                setBooks(data);
            } catch (error) {
                setError('Failed to fetch checks' + error);
            } finally {
                setLoading(false);
            }
        }
        fetchBooks();
    }, []);

    return { books, loading, error};
}

export default GetAllBooks;