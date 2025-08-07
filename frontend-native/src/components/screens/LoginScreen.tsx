import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import { KakaoButton, LoginButton, SignupButton } from '../CustomButton';

export default function LoginScreen() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loginMessage, setLoginMessage] = useState('')

  const handleLogin = () => {
    console.log('로그인 시도:', email, password);
    // 여기에 API 연동 추가 가능
  };

  return (
    <View style={styles.container}>
      <Text style={styles.logo}>Team Heart Of Guro</Text>
      <TextInput
        placeholder="이메일"
        value={email}
        onChangeText={setEmail}
        style={styles.input}
      />
      <TextInput
        placeholder="비밀번호"
        value={password}
        onChangeText={setPassword}
        secureTextEntry
        style={styles.input}
      />
      <LoginButton onPress={handleLogin} />
      <SignupButton onPress={() => setLoginMessage('회원가입은 아직입니다.')} />
      <KakaoButton onPress={() => setLoginMessage('카카오 로그인은 나중에~')} />
      <Text style={styles.message}>{loginMessage}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 24,
    justifyContent: 'center',
  },
  logo: {
    fontSize: 28,
    fontWeight: 'bold',
    marginBottom: 24,
    textAlign: 'center',
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 6,
    padding: 12,
    marginBottom: 12,
  },
  message: {
    marginTop: 20,
    textAlign: 'center',
    fontSize: 16,
    color: 'blue',
  },
});