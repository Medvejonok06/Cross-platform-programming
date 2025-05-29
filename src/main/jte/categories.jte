@import com.example.demo.entity.Category
@import org.springframework.security.core.context.SecurityContextHolder
@param Iterable<Category> categories
@param String sort
@param String search

<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Категорії</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: start;
            padding-top: 60px;
        }

        .container {
            background: white;
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            width: 600px;
        }

        h1 {
            margin-bottom: 20px;
            text-align: center;
        }

        .search-box {
            margin-bottom: 20px;
            text-align: center;
        }

        .search-box input[type="text"] {
            padding: 8px;
            width: 250px;
            border-radius: 6px;
            border: 1px solid #ccc;
            margin-right: 8px;
        }

        .search-box button {
            padding: 8px 14px;
            background-color: #17a2b8;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        .search-box button:hover {
            background-color: #138496;
        }

        .sort-buttons {
            margin-bottom: 16px;
            text-align: center;
        }

        .sort-buttons a {
            display: inline-block;
            margin: 6px 8px;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
        }

        .sort-buttons a:hover {
            background-color: #0056b3;
        }

        .add-button {
            display: inline-block;
            margin-bottom: 16px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
        }

        .add-button:hover {
            background-color: #218838;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            padding: 12px;
            margin-bottom: 12px;
            background-color: #f9f9f9;
            border-radius: 8px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .edit-link, .delete-button {
            padding: 6px 10px;
            font-size: 14px;
            margin-left: 4px;
            border-radius: 6px;
            border: none;
            cursor: pointer;
        }

        .edit-link {
            background-color: #17a2b8;
            color: white;
            text-decoration: none;
        }

        .edit-link:hover {
            background-color: #138496;
        }

        .delete-button {
            background-color: #dc3545;
            color: white;
        }

        .delete-button:hover {
            background-color: #c82333;
        }

        .footer {
            text-align: center;
            margin-top: 24px;
        }

        .footer a {
            color: #555;
            text-decoration: none;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Список категорій</h1>

    <div class="search-box">
        <form action="/categories" method="get">
            <input type="text" name="search" placeholder="Пошук категорії..." value="${search}" />
            <button type="submit">🔍 Знайти</button>
        </form>
    </div>

    <div class="sort-buttons">
        <a href="/categories?sort=asc">Сортування в алфавітному порядку (А → Я)</a>
        <a href="/categories?sort=desc">Сортування в алфавітному порядку (Я → А)</a>
    </div>

    @if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN"))
        <a href="/categories/add" class="add-button">➕ Додати категорію</a>
    @endif

    <ul>
        @for (Category category : categories)
            <li>
                ${category.getName()}
                @if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN"))
                    <div>
                        <a href="/categories/edit/${category.getCategoryId()}" class="edit-link">Редагувати</a>
                        <form action="/categories/delete" method="post" style="display:inline;" onsubmit="return confirm('Видалити категорію?');">
                            <input type="hidden" name="categoryId" value="${category.getCategoryId()}">
                            <button class="delete-button" type="submit">Видалити</button>
                        </form>
                    </div>
                @endif
            </li>
        @endfor
    </ul>

    <div class="footer">
        <a href="/logout">Вийти з акаунту</a>
    </div>
</div>
</body>
</html>
