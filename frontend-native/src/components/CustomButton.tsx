// components/CustomButton.tsx
import React from 'react';
import { TouchableOpacity, Text, StyleSheet } from 'react-native';

interface ButtonProps {
  title: string;
  onPress: () => void;
  backgroundColor: string;
  textColor?: string;
}

function BaseButton({ title, onPress, backgroundColor, textColor = '#fff' }: ButtonProps) {
  return (
    <TouchableOpacity style={[styles.button, { backgroundColor }]} onPress={onPress}>
      <Text style={[styles.text, { color: textColor }]}>{title}</Text>
    </TouchableOpacity>
  );
}

// 개별 버튼 export
export const LoginButton = ({ onPress }: { onPress: () => void }) => (
  <BaseButton title="로그인" onPress={onPress} backgroundColor="#2980b9" />
);

export const SignupButton = ({ onPress }: { onPress: () => void }) => (
  <BaseButton title="회원가입" onPress={onPress} backgroundColor="#27ae60" />
);

export const KakaoButton = ({ onPress }: { onPress: () => void }) => (
  <BaseButton title="카카오 로그인" onPress={onPress} backgroundColor="#FEE500" textColor="#000" />
);

const styles = StyleSheet.create({
  button: {
    paddingVertical: 12,
    paddingHorizontal: 24,
    borderRadius: 6,
    marginVertical: 6,
  },
  text: {
    fontSize: 16,
    textAlign: 'center',
  },
});
