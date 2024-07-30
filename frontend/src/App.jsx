import {useEffect, useState} from 'react';
import './App.css';

export default function App() {
    const [listing, setListing] = useState([]);
    const [count, setCount] = useState(0);

    async function getListings() {
        const response = await fetch("http://localhost:8080/api/listings");
        const data = await response.json();
        setListing([data[0].title, data[0].description]);
        setCount(count + 1);
    }

    useEffect(() => {
        getListings();
    }, []);

    return (
        <>
            <div>
                <button onClick={getListings}>Get Listings</button>
                <h1>First listing:</h1>
                <h2>Title: {listing[0]}</h2>
                <h2>Description: {listing[1]}</h2>
                <Message count={count} />
            </div>
        </>
    );
}

function Message(props) {
    return (
        <div>
            <h1>Count: {props.count}</h1>
        </div>
    )
}

