let todoItemsContainer = document.getElementById("todoItemsContainer");
let addTodoButton = document.getElementById("addTodoButton");
let saveTodoButton = document.getElementById("saveTodoButton");

// Fetch the todo list from local storage
function getTodoListFromLocalStorage() {
    const stringifiedTodoList = localStorage.getItem("todoList");
    return JSON.parse(stringifiedTodoList) || [];
}

let todoList = getTodoListFromLocalStorage();
let todosCount = todoList.length;

// Save the current todo list to local storage
saveTodoButton.onclick = function() {
    localStorage.setItem("todoList", JSON.stringify(todoList));
    alert("Todo list saved!");
};

// Function to add a new todo
function onAddTodo() {
    const userInputElement = document.getElementById("todoUserInput");
    const userInputValue = userInputElement.value.trim();

    if (!userInputValue) {
        alert("Please enter valid text.");
        return;
    }

    todosCount++;
    const newTodo = {
        text: userInputValue,
        uniqueNo: todosCount,
        isChecked: false
    };
    
    todoList.push(newTodo);
    createAndAppendTodo(newTodo);
    userInputElement.value = "";
}

// Event listener for adding todos
addTodoButton.onclick = onAddTodo;

// Toggle the status of a todo
function onTodoStatusChange(checkboxId, labelId, todoId) {
    const checkboxElement = document.getElementById(checkboxId);
    const labelElement = document.getElementById(labelId);
    
    labelElement.classList.toggle("checked");
    
    const todoObject = todoList.find(todo => 'todo' + todo.uniqueNo === todoId);
    todoObject.isChecked = checkboxElement.checked;
}

// Delete a todo
function onDeleteTodo(todoId) {
    const todoElement = document.getElementById(todoId);
    todoItemsContainer.removeChild(todoElement);

    const deleteElementIndex = todoList.findIndex(todo => 'todo' + todo.uniqueNo === todoId);
    todoList.splice(deleteElementIndex, 1);
}

// Create and append a todo item to the list
function createAndAppendTodo(todo) {
    const todoId = "todo" + todo.uniqueNo;
    const checkboxId = "checkbox" + todo.uniqueNo;
    const labelId = "label" + todo.uniqueNo;

    const todoElement = document.createElement("li");
    todoElement.classList.add("todo-item-container", "d-flex", "flex-row");
    todoElement.id = todoId;
    todoItemsContainer.appendChild(todoElement);

    const inputElement = document.createElement("input");
    inputElement.type = "checkbox";
    inputElement.id = checkboxId;
    inputElement.checked = todo.isChecked;
    inputElement.onclick = () => onTodoStatusChange(checkboxId, labelId, todoId);
    inputElement.classList.add("checkbox-input");
    todoElement.appendChild(inputElement);

    const labelContainer = document.createElement("div");
    labelContainer.classList.add("label-container", "d-flex", "flex-row");
    todoElement.appendChild(labelContainer);

    const labelElement = document.createElement("label");
    labelElement.setAttribute("for", checkboxId);
    labelElement.id = labelId;
    labelElement.classList.add("checkbox-label");
    labelElement.textContent = todo.text;
    if (todo.isChecked) {
        labelElement.classList.add('checked');
    }
    labelContainer.appendChild(labelElement);

    const deleteIconContainer = document.createElement("div");
    deleteIconContainer.classList.add("delete-icon-container");
    labelContainer.appendChild(deleteIconContainer);

    const deleteIcon = document.createElement("i");
    deleteIcon.classList.add("far", "fa-trash-alt", "delete-icon");
    deleteIcon.onclick = () => onDeleteTodo(todoId);
    deleteIconContainer.appendChild(deleteIcon);
}

// Initialize the todo list from local storage
todoList.forEach(createAndAppendTodo);
