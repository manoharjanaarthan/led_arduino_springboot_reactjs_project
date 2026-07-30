import './App.css';
import LightControl from './components/LightControl';

function App() {

    return (

        <div className="container">

            <LightControl color="Red"/>

            <LightControl color="Green"/>

            <LightControl color="Blue"/>

        </div>

    );

}

export default App;