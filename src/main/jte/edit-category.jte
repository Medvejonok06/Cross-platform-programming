@import com.example.demo.entity.Category
@param Category category

<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Редагування категорії</title>
    <style>
        body {
            font-family: sans-serif;
            background: #f3f3f3;
            display: flex;
            justify-content: center;
            padding-top: 100px;
        }

        .form-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            width: 400px;
        }

        h1 {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            margin-bottom: 20px;
        }

        button {
            background: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 6px;
            cursor: pointer;
        }

        a {
            display: inline-block;
            margin-top: 10px;
            color: #555;
        }
    </style>
</head>
<body>
<div class="form-box">
    <h1>Редагування категорії</h1>
    <form action="/categories/update" method="post">
        <input type="hidden" name="categoryId" value="${category.getCategoryId()}">

        <label for="name">Назва категорії:</label>
        <input type="text" id="name" name="name" value="${category.getName()}" required>

        <button type="submit">Зберегти зміни</button>
    </form>
    <a href="/categories">← Назад до списку</a>
</div>
</body>
</html>
