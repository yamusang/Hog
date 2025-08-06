import React, { useEffect } from 'react'
import axios from 'axios'
// 이곳은 카카오로그인 중간 경유지
export default function Kakaocallback() {
    useEffect(()=>{
        const SendCode = async() => {
            const params = new URLSearchParams(window.location.href)
            const code = params.get('code')
            try {
                const res = await axios.post('http://localhost:8080/api/kakao-login', {
                    code,
                })
        const token = res.data
        localStorage.setItem('token', token)
        window.location.href = "/home" 
            } catch (error) {
                console.error("카카오 로그인 실패",error)
            }
        }
        SendCode()
    },[])
  return (
    <div>LOADING....</div>
  )
}
