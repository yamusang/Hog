import React from 'react'
import { LogoutBtn } from './buttons/button'

export default function LogoutForm() {
    const handlelogout = () => {
        localStorage.removeItem("token") // 토큰 제거
        alert("로그아웃 되었습니다.")
        window.location.href = "/"
    }
  return (
    <LogoutBtn onClick={handlelogout}/>
  )
}
