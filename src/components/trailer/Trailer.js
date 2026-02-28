import { useParams } from 'react-router-dom';
import ReactPlayer from 'react-player';
import './Trailer.css';
import React, { useState } from 'react';

const Trailer = () => {
    // Extract the ytTrailerId from the URL parameters using useParams hook
    // This allows us to get the dynamic part of the URL /Trailer/:ytTrailerId
    let params = useParams();
    
    // Get the key (YouTube video ID) from the parameters
    // This matches the route definition: /Trailer/:ytTrailerId
    const key = params.ytTrailerId;

    // Use state to manage playing status to avoid errors like 
    // "The play() request was interrupted because the media was removed from the document"
    const [playing, setPlaying] = useState(false);

    return (
        <div className="react-player-container">
            {/* 
               Render ReactPlayer only if 'key' is present.
               'playing={playing}' uses state to control playback, starting false
               and switching to true only when the player is ready via onReady callback.
               'controls={true}' shows the native player controls.
            */}
            {(key != null) ? (
                <ReactPlayer 
                    controls={true} 
                    playing={playing} 
                    url={`https://www.youtube.com/watch?v=${key}`}
                    width='100%' 
                    height='100%' 
                    onReady={() => setPlaying(true)}
                    onError={(e) => console.log("Video error:", e)}
                />
            ) : null}
        </div>
    )
}

export default Trailer