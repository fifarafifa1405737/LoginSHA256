import hashlib

# Registrasi User
print("=== REGISTRASI USER ===")
username = input("Masukkan Username : ")
password = input("Masukkan Password : ")

# Ubah password ke hash SHA-256
simpan_hash = hashlib.sha256(password.encode()).hexdigest()
simpan_user = username

# Tampilkan hasil hash
print("\nData berhasil disimpan!")
print("Username :", simpan_user)
print("Hash Password :", simpan_hash)

# Login User
print("\n=== LOGIN USER ===")
login_user = input("Masukkan Username : ")
login_pass = input("Masukkan Password : ")

# Verifikasi Login
login_hash = hashlib.sha256(login_pass.encode()).hexdigest()

if login_user == simpan_user and login_hash == simpan_hash:
    print("Status Login : BERHASIL")
else:
    print("Status Login : GAGAL")