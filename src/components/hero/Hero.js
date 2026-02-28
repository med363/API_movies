//child component of home, it will display the hero section of the home page, it will receive the movies data as a prop from the home component and display the hero section accordingly.
import React from 'react'
import './hero.css'
import Carousel from 'react-material-ui-carousel'
import { Paper, Button } from '@mui/material'   
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faC, faCirclePlay } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'
const Hero = ({ movies }) => {
  return (
    <div>
        <Carousel>
            {movies && movies.map((movie) => (
                <Paper key={movie.id} className="movie-card-container">
                    <div className="movie-card" style={{"--img": `url(${movie.backdrops[0]})`}}>
                        <div className="movie-detail">
                            <div className="movie-poster">
                                <img src={movie.poster || movie.backdrops[0]} alt="" />
                            </div>
                            <div className="movie-title">
                                <h2>{movie.title}</h2>
                                <p>{movie.description}</p>
                            </div>
                            <div className="movie-buttons-container">
                                <Link to={`/trailer/${movie.ytTrailerId}`} className="play-button-link">
                                <div className='play-button-icon-container'>
                                    <FontAwesomeIcon className='play-button-icon'
                                        icon= {faCirclePlay
                                        } />
                                </div>
                                </Link>

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