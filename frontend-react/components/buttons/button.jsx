import React from 'react'

    export function LoginBtn({onClick}){
        return <button onClick={onClick} className='loginbtn'>로그인</button>
    }
    export function LogoutBtn({onClick}){
        return <button onClick={onClick} className='logoutbtn'>로그아웃</button>
    }
    export function SignupBtn({onClick}){
        return <button onClick={onClick} className='signupbtn'>회원가입</button>
    }
    export function KakaoBtn({onClick}){
        return <button onClick={onClick} className='kakaobtn'>카카오톡 로그인</button>
    }