//child component of home, it will display the hero section of the home page, it will receive the movies data as a prop from the home component and display the hero section accordingly.
import React from 'react'
import './hero.css'
import Carousel from 'react-material-ui-carousel'
import { Paper, Button } from '@mui/material'   
const Hero = ({ movies }) => {
  return (
    <div>
        <Carousel>
            {movies && movies.map((movie) => (
                <Paper key={movie.id}>
                    <img src={movie.backdrops} alt={movie.title} className='hero-image' />
                    <h2>{movie.title}</h2>
                    <p>{movie.description}</p>
                </Paper>
            ))
            }
        </Carousel>
    </div>
  )
}

export default Hero