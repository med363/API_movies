// Child component of Home.
// Displays the hero section (carousel) of the home page.
// Receives the 'movies' array as a prop from the Home component.
import React from 'react'
import './hero.css'
// Carousel component for sliding through movie items
import Carousel from 'react-material-ui-carousel'
import { Paper } from '@mui/material'   
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCirclePlay } from '@fortawesome/free-solid-svg-icons'
import { Link, useNavigate } from 'react-router-dom'
import Button from 'react-bootstrap/Button';

const Hero = ({ movies }) => {

    // Hook to programmatically navigate to other routes
    const navigate = useNavigate();

    // Function to navigate to the reviews page for a specific movie
    function reviews(movieId)
    {
        navigate(`/Reviews/${movieId}`);
    }

  return (
    <div className='movie-carousel-container'>
        <Carousel>
            {/* Map through the movies array to create a carousel item for each movie */}
            {movies && movies.map((movie) => (
                <Paper key={movie.imdbId}>
                    <div className='movie-card-container'>
                        {/* 
                            Inline style to set the background image dynamically.
                            This CSS variable (--img) is used in hero.css.
                        */}
                        <div className="movie-card" style={{"--img": `url(${movie.backdrops[0]})`}}>
                            <div className="movie-detail">
                                <div className="movie-poster">
                                    <img src={movie.poster} alt="" />
                                </div>
                                <div className="movie-title">
                                    <h4>{movie.title}</h4>
                                </div>
                                <div className="movie-buttons-container">
                                    {/* 
                                        Link to the Trailer component.
                                        Extracts the YouTube video ID from the trailerLink URL.
                                        Assumes trailerLink ends with the 11-char ID.
                                    */}
                                    <Link to={`/Trailer/${movie.trailerLink.substring(movie.trailerLink.length - 11)}`}>
                                        <div className="play-button-icon-container">
                                            <FontAwesomeIcon className="play-button-icon"
                                                icon = {faCirclePlay}
                                            />
                                        </div>
                                    </Link>

                                    <div className="movie-review-button-container">
                                        <Button variant ="info" onClick={() => reviews(movie.imdbId)} >Reviews</Button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </Paper>
            ))
            }
        </Carousel>
    </div>
  )
}

export default Hero