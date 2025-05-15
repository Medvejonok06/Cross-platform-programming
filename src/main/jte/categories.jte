@import com.example.demo.entity.Category
@param Iterable<Category> categories

<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Категорії</title>
</head>
<body>
<h1>Список категорій</h1>
<ul>
    @for (Category category : categories)
        <li>${category.getName()}</li>
    @endfor
</ul>
</body>
</html>
