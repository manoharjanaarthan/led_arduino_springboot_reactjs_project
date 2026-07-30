import React, { useState } from "react";
import LightService from "../services/LightService";

const LightControl = ({ color }) => {

    const [isOn, setIsOn] = useState(false);

    const switchOn = () => {

        LightService
            .operateLight("ON", color.toLowerCase())
            .then(() => {
                setIsOn(true);
            })
            .catch(console.error);

    };

    const switchOff = () => {

        LightService
            .operateLight("OFF", color.toLowerCase())
            .then(() => {
                setIsOn(false);
            })
            .catch(console.error);

    };

    return (

        <div className="light-card">

            <div
                className="circle"
                style={{
                    backgroundColor: color.toLowerCase(),
                    opacity: isOn ? 1 : 0.3
                }}
            >
            </div>

            <h3>{color}</h3>

            <button
                onClick={switchOn}
                disabled={isOn}
            >
                ON
            </button>

            <button
                onClick={switchOff}
                disabled={!isOn}
            >
                OFF
            </button>

        </div>

    );

};

export default LightControl;