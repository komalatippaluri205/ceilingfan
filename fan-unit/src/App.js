import { useEffect, useState } from 'react';
import './App.css';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import FormLabel from '@mui/material/FormLabel';
import Chip from '@mui/material/Chip';

function App() {

  const [speed, setSpeed] = useState(['OFF']);
  const [direction, setDirection] = useState(['FORWARD']);

  function pullcord1(){
    fetch("http://localhost:8080/pullcord1").then(res => res.text()).then(res => setSpeed(res));
  }
  
  function pullcord2(){
    fetch("http://localhost:8080/pullcord2").then(res => res.text()).then(res => setDirection(res));
  }

  useEffect(() => {
      fetch("http://localhost:8080/reset-fan").then(res => res.json()).then(res => {
        setSpeed(res.speed);
        setDirection(res.direction);
      });
  },[]);

  return (
    <div className="App">
      <header className="App-header">
        
      <Container maxWidth="sm">
        <Box sx={{ bgcolor: '#cfe8fc', height: '50vh' }} alignContent='center' >
        
        <div>
        <FormLabel color='primary'>Speed Setting </FormLabel> <Chip label={speed} variant="outlined" color='primary'/><br/>
        <FormLabel color='primary'>Direction </FormLabel><Chip label={direction} variant="outlined" color='primary'/></div>
      <br/><br/>
        <Button variant='contained' onClick={pullcord1}>Cord1</Button><Button variant='contained' onClick={pullcord2}>Cord2</Button>

        </Box>
      </Container>
          

      </header>
    </div>
  );
}

export default App;
