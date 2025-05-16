import { useMemo, type JSX } from "react";

import GetAllBooks from "../services/GetAllBooks";

function Home () {

    const { books } = GetAllBooks();


    const listOfBooks = useMemo(():JSX.Element[] => {

        const allBooks:JSX.Element[] = [];

        books.map(book => {
            allBooks.push(
                <li key={book.id}>
                    {book.name}
                </li>
            )
        });

        return allBooks;
    }, [books])


    return (
        <main>
            <ul>
                {listOfBooks}
            </ul>
        </main>
    )
}

export default Home;