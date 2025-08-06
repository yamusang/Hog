import React, { useEffect, useState } from 'react'
import { KakaoBtn, LoginBtn} from './buttons/button'
import api from '../api/api'

export default function LoginForm() {
    const [email, setemail] = useState("")
    const [password, setpassword] = useState("")
    const [message, setmessage] = useState("")
    const [KAKAO_AUTH_URL, setKAKAO_AUTH_URL] = useState("")

    // 카카오톡
    useEffect(()=>{
        const REST_API_KEY = "f06cf639edb35cf75245bd8280da84de"
        const REDIRECT_URI = "http://localhost:5173/auth/kakao/callback"
        const STATE = crypto.randomUUID()
        sessionStorage.setItem("kakao_login_state", STATE)

        const url = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code&state=${STATE}`
        
        setKAKAO_AUTH_URL(url)
    },[])
    const handlekakaologin = () => {
        window.location.href = KAKAO_AUTH_URL
    }

    // 일반 로그인
    const handlelogin = async (e) => {
        e.preventDefault()
        try {
            const res = await api.post('/login', {
                useremail: email,
                userpassword: password
            })
            localStorage.setItem('token', res.data.token)
            window.location.href = '/home'
            setmessage('로그인 성공')
        } catch (error) {
            setmessage("로그인 실패")
        }
    }
    
  return (
    <form className='form' onSubmit={handlelogin}>
        <input 
        type="text"
        placeholder='EMAIL'
        value={email}
        onChange={(e) => setemail(e.target.value)}
        />
        <input 
        type="password"
        placeholder='PASSWORD'
        value={password}
        onChange={(e) => setpassword(e.target.value)}
        />
        <LoginBtn/>
        <KakaoBtn onClick={handlekakaologin}/>
        <span>{message}</span>
    </form>
  )
}
