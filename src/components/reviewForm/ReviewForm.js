import React from 'react'
import { Form, Button } from 'react-bootstrap';

const ReviewForm = ({ handleSubmit, revText, labelText, defaultValue, movie, reviews }) => {
    return (
        <Form>
            {movie && (
                <div className="mb-3 text-center">
                    <img 
                        src={movie.poster || movie.backdrops?.[0]} 
                        alt="Movie Poster" 
                        style={{ maxWidth: '200px', borderRadius: '10px', marginBottom: '10px' }} 
                    />
                </div>
            )}
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>{labelText}</Form.Label>
                <Form.Control ref={revText} as="textarea" rows={3} defaultValue={defaultValue} />
            </Form.Group>
            <Button variant="outline-info" onClick={(e) => handleSubmit(e)}>Submit</Button>
            
            <div className="mt-4">
                <h4>User Reviews:</h4>
                <div className="review-list">
                    {reviews?.map((r, index) => (
                        <div key={index} className="mb-3 border-bottom pb-2">
                            {r.body}
                        </div>
                    ))}
                </div>
            </div>
        </Form>
    )
}

export default ReviewForm
