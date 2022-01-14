import Pagination from "components/Pagination";
import MovieCard from "components/MovieCard";
import axios from "axios";
import { useState } from "react";
import { useEffect } from "react";
import { BASE_URL } from "utils/requests";
import { MoviePage } from "types/movie";

function Listing(){

    const [pageNumber, setPageNumber] = useState(0);

    useEffect(() => {
        
        axios.get(`${BASE_URL}/movies?size=12&page=0`)
        .then(response => {
            const data = response.data as MoviePage;
            setPageNumber(data.number);
        }).then()

    }, [])



    return(
        <>
            <Pagination />
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-md-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                </div>
            </div>
       </>
    );
}

export default Listing;