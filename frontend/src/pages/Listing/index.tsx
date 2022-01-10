import Pagination from "components/Pagination";
import MovieCard from "components/MovieCard";

function Listing(){
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