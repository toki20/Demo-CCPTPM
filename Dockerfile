# Sử dụng Nginx Alpine để tối ưu dung lượng
FROM nginx:alpine

# Sao chép file index.html vào thư mục mặc định của Nginx
COPY index.html /usr/share/nginx/html/index.html

# Mở cổng 80 (cổng mặc định của Nginx)
EXPOSE 80
