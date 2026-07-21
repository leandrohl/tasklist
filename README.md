<h1>Desafio prático - TaskList </h1>
Crie uma aplicação que represente uma "Lista de tarefas", que permita aos usuários criar e gerenciar tarefas.


##  :notebook_with_decorative_cover: Funcionalidades obrigatórias

- Utilize companion object para gerar IDs únicos automaticamente para cada Task.
- Implemente uma classe TaskManager com métodos para:
  - Adicionar uma nova tarefa.
  - Listar todas as tarefas (destruturando title e isCompleted). 
  - Buscar uma tarefa por ID. 
  - Atualizar o status (isCompleted) de uma tarefa específica. 
  - Excluir uma tarefa pelo ID. 
  - Filtrar tarefas concluídas ou pendentes usando filter.
- Use funções de validação como require para garantir que o título da tarefa não está vazio e a tarefa existe antes de tentarmos excluir ou atualiza-lá.
- Utilize sealed classes para representar o retorno das operações com os estados de sucesso (com uma mensagem personalizada) e erro (com uma mensagem de erro).
- Adicione funções para converter a task em uma string formatada, e obter a contagem de tarefas diretamente da lista.
