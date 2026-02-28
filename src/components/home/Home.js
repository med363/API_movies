import React from 'react'
import Hero from '../hero/Hero'
// The Home component is a functional component that receives a prop called movies. It currently renders a simple div with the text "Home". You can modify this component to display the movies data as needed.
const Home = ({ movies }) => {
  return (
    <Hero movies={movies} />
  )
}

export default Home