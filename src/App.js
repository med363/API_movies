import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
function App() {
  const [movies, setMovies] = useState();

  const getMovies = async () => {
    const res= await api.get("/api/v1/movies");
    setMovies(res.data);
  }
  useEffect(() => {
    getMovies();
  }, []);
  return (
    <div className="App">
<h1>Welcome to my React App!</h1>
    </div>
  );
}

export default App;
