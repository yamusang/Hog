import React, { useState } from 'react'
import { SignupBtn } from './buttons/button'
import api from '../api/api'

export default function SignupForm() {
    const [useremail, setuseremail] = useState("")
    const [username, setusername] = useState("")
    const [password, setpassword] = useState("")
    const [confirmpw, setconfirmpw] = useState("") // 비밀번호 재확인
    const [message, setmessage] = useState("")

    const isMatch = password === confirmpw // 비밀번호 일치하는지 확인
    const isValidEmail = useremail.includes('@') && useremail.includes('.') // 이메일 형식 확인
    const isFormValid = useremail && username && isValidEmail && password && isMatch // 조건 만족시 가입 버튼 활성화

    const handlesubmit = async (e) => {
        e.preventDefault()
        try {
            const res = await api.post('/signup', {useremail, username, password})
            localStorage.setItem('token', res.data.token)
            setmessage("회원가입 되었습니다 로그인 후 이용해주세요.")
        } catch (error) {
            setmessage("회원가입 실패")
        }
    }
  return (
    <form className='form' onSubmit={handlesubmit}>
        <input type="email" placeholder='EMAIL' value={useremail} onChange={(e)=> setuseremail(e.target.value)}/>
        <input type="text" placeholder='USER NAME' value={username} onChange={(e)=> setusername(e.target.value)}/>
        <input type="password" placeholder='PASSWORD' value={password} onChange={(e)=> setpassword(e.target.value)}/>
        <input type="password" placeholder='CONFIRM PASSWORD' value={confirmpw} onChange={(e)=> setconfirmpw(e.target.value)}/>
        <SignupBtn disabled={!isFormValid}/>
        <span>{message}</span>
    </form>
  )
}
