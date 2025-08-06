import { useState } from 'react'
import { LoginBtn, SignupBtn } from '../components/buttons/button'
import SignupForm from '../components/SignupForm'
import LoginForm from '../components/LoginForm'



export default function LoginPage() {
    const [isopen, setisopen] = useState(false)
    const [isopen2, setisopen2] = useState(false)

    const toggleForm = () => setisopen(!isopen)
    const toggleForm2 = () => setisopen2(!isopen2)

  return (
    <div>
        <SignupBtn onClick={toggleForm}/>
        <div className={`wrapper ${isopen? 'open' : ''}`}>
            <SignupForm/>
        </div>
        <LoginBtn onClick={toggleForm2}/>
        <div className={`wrapper ${isopen2? 'open' : ''}`}>
            <LoginForm/>
        </div>
    </div>
  )
}
