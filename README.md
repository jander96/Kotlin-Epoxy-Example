# Kotlin-Epoxy-Example
Este es un ejemplo sencillo de como usar la libreria de **epoxy** para la creación de interfaces complejas que requieran de listados.
Google a creado los _RecyclerView_ pero el uso de estos puede ser repetitivo y complejo en algunos tipos de vistas
###### Ejemplo

~~~~
 class ProjectHomeAdapter(private val projectPicked: (projectId: String) -> Unit) :
    ListAdapter<Project, ProjectHomeAdapter.InboxViewHolder>(DiffutilCallbackInboxTask) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxViewHolder {
        return InboxViewHolder(
            RecyclerProjectItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InboxViewHolder, position: Int) {
        holder.bind(getItem(position), projectPicked)
    }

    class InboxViewHolder(private val binding: RecyclerProjectItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Project, projectPicked: (projectId: String) -> Unit) {
            if (project.color != null) {
                val color = GetColorResourceByCode.getResource(project.color)
                binding.viewProjectColor.background =
                    AppCompatResources.getDrawable(binding.root.context, color)
            }

            binding.tvProjectName.text = project.name
            binding.layout.setOnClickListener {
                projectPicked(project.id)
            }
            if (project.isFavorite != null && project.isFavorite) {
                binding.ivFavorite.setImageDrawable(
                    AppCompatResources.getDrawable(
                        binding.root.context,
                        R.drawable.favorite_svgrepo_com
                    )
                )
            } else binding.ivFavorite.setImageDrawable(
                AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.not_favorite
                )
            )

        }

    }

    private object DiffutilCallbackInboxTask : DiffUtil.ItemCallback<Project>() {
        override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean =
            oldItem == newItem
    }
}
~~~~



Con [epoxy](https://github.com/airbnb/epoxy) simplificamos mucho el trbajo al usar un principio similar al de Jectpack Compose que es la componibilidad 

En el ejemplo de este repositorio tenemos un listado tal asi:
![](https://raw.githubusercontent.com/jander96/Kotlin-Epoxy-Example/master/Screenshot_20230120_092541.png)
![](https://raw.githubusercontent.com/jander96/Kotlin-Epoxy-Example/master/Screenshot_20230120_092702.png)
![](https://raw.githubusercontent.com/jander96/Kotlin-Epoxy-Example/master/Screenshot_20230120_092734.png)
Este listado complejo con un _Header_, un _Body_, que contiene varios recyclerView anidados, más otro listado de un texto descriptivo y un _Bottom_; usando los adapters de Google con el RecyclerView sería un código  largo, repetitivo y complejo. En su lugar tenemos algo como esto: 

~~~~
class MainEpoxyController(
    private val onClickCallBack: (String)->Unit
): EpoxyController(){
    // list of personage
    var personages: List<Personage> = emptyList()
     set(value) {
         field = value
         requestModelBuild()
     }
    override fun buildModels() {
        // Header
        HeadModel()
            .id("head")
            .addTo(this)
       personages.forEach { personage->
           CarrouselModel(personage)
               .id("carousel")
               .addTo(this)

       }
        // Descriptions
        personages.forEach {personage ->
            DescriptionModel(personage){
                onClickCallBack(personage.name)
            }.id("desc")
                .addTo(this)
        }
        // Bottom
        BottomModel()
            .id("fin")
            .addTo(this)

    }
}
~~~~

Un código más limpio corto y entendible

En resumen solo se trata de usar 2 componentes básicos 
1. El Model
2. El Controller

Para más detalles puede leer la [documentación](https://github.com/airbnb/epoxy/wiki/Basic-Usage) de la librería 

Escrito por Jander Laffita Orduñez el 20-1-2023
