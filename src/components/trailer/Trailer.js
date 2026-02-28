import { useParams } from 'react-router-dom';
import ReactPlayer from 'react-player';
import './Trailer.css';
import React from 'react';

const Trailer = () => {
    // Extract the ytTrailerId from the URL parameters using useParams hook
    let params = useParams();
    // Get the key (YouTube video ID) from the parameters
    let key = params.ytTrailerId;

    return (
        <div className="react-player-container">
            {/* If key is not null, display the ReactPlayer component playing the trailer */}
            {(key != null) ? (
                <ReactPlayer 
                    controls={true} 
                    playing={true} 
                    url={`https://www.youtube.com/watch?v=${key}`}
                    width='100%' 
                    height='100%' 
                />
            ) : null}
        </div>
    )
}

export default Trailer